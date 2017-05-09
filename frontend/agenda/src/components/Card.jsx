import React from 'react';
import Avatar from './Avatar';
import Item from './Item';

class Card extends React.Component {
    render(){
        return (
            <a className="card">
                <Avatar/>
                <Item />
            </a>
        );
    }
}

export default Card;