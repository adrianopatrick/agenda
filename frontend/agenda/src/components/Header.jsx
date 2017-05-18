import React from 'react';
import Search from './Search';

const Header = (props) => (

    <div className="tela-contatos">

        <div className="title">
            <div className="title-texto">
                Linkers - Agenda
            </div>
        </div>

       <Search filtro={props.filtro} change={props.change}/>

        <div className="line-separator" />
    </div>

);

export default Header;