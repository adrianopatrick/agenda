import React from 'react';

const Avatar = (props) => {

    const siglaNome = (nome) => {
      let partes = nome.split(" ");
      let sigla = partes[0].charAt(0).toUpperCase();
      if(partes.length > 1) {
          sigla += partes[partes.length - 1].charAt(0).toUpperCase();
      } else {
          sigla += partes[0].charAt(1).toUpperCase();
      }
      return sigla;
    };

    return (
        <div className="avatar-circle">
            <span className="initials">{siglaNome(props.value)}</span>
        </div>
    )
};

export default Avatar;