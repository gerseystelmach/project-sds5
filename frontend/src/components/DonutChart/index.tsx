import axios from 'axios';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { BASE_URL } from 'utils/requests';

/* Definindo o tipo dos dados que serão recebidos no api */ 
type ChartData = {
    labels: string[];
    series: number[];
}
const DonutChart = () => {

    /* Forma errada */
    let chartData : ChartData = { labels: [], series: []};

    axios.get(`${BASE_URL}/sales/total-amount-by-seller`)
        .then(response => {
            /* Puxando dados da Api, confrome tipos definidos no arquivo sale.ts */
            const data = response.data as SaleSum[];
            /* Filtrando dados da API e criando uma nova coleção para aplicar no chart */
            const myLabels = data.map(x => x.sellerName);
            const mySeries = data.map(x => x.sum);

            chartData = { labels: myLabels, series: mySeries};
            console.log(chartData);
        });
/*     
    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    } */
    
    const options = {
        legend: {
            show: true
        }
    }
    
    return (

/*  Chart é um componente criado pela livraria ApexCharts. Preciso indicar os parâmetros necessários para que o chart seja criado. Source: https://apexcharts.com/docs/react-charts/  */
     <Chart options={{...options, labels: chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
     />
    );
}

export default DonutChart;
