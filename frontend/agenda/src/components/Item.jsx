import React from 'react';

const Item = (props) => (
    <div className="item">
        <div className="texto">{props.value}</div>
    </div>
);

export default Item;