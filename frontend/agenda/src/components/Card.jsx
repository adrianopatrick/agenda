import React from 'react';
import Avatar from './Avatar';
import Item from './Item';

class Card extends React.Component {
    render(){
        return (
            <a className="card">
                <Avatar value={this.props.contato.nome}/>
                <Item value={this.props.contato.nome}/>
            </a>
        );
    }
}

export default Card;