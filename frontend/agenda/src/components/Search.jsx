import React from 'react';

const Search = (props) => (
    <div className="search">
        <form>
            <div>
                <input value={props.filtro} type="search" className="empty"
                       placeholder="&#xF002; Pesquisar" onChange={props.change} />
            </div>
        </form>
    </div>
);

export default Search;