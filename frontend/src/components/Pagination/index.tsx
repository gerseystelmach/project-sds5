import { SalePage } from "types/sale";

type Props = {
    page: SalePage;
    onPageChange: Function; // Para fazer a comunicação com o componente
}

const Pagination = ( { page, onPageChange } : Props ) => {
    return (
        <div className="row d-flex justify-content-center">
            <nav>
                <ul className="pagination">
                    {/* Aplicando a classe disabled do bootstrap somente na primeira e última página */}
                        <li className={`page-item ${page.first ? 'disabled' : ''}`}>
                        <button className="page-link" onClick={() => onPageChange(page.number - 1)}>Before</button>
                    </li>
                    <li className="page-item disabled">
                        <span className="page-link">{page.number + 1}</span>
                    </li>
                    <li className={`page-item ${page.last ? 'disabled' : ''}`}>
                        <button className="page-link" onClick={() => onPageChange(page.number + 1)}>Next</button>
                    </li>
                </ul>
            </nav>
        </div>
    )
}

export default Pagination;