/**
 * Created by unifor on 17/05/17.
 */
import React from 'react';

import Header from '../components/Header';
import Card from '../components/Card';
import Add from '../components/Add';

import URLS from '../config/URLS'

class Agenda extends React.Component {

    constructor() {
        super();
        this.state = {
            filtro: '',
            onDemandContatos: [],
            contatos: []
        };

        this.change = this.change.bind(this);
        this.refresh = this.refresh.bind(this);
    }

    change(event) {
        this.setState({...this.state, filtro: event.target.value}, this.refresh);
    }

    refresh() {
        const contatos = this.state.contatos.filter(contato => contato.nome.toLowerCase()
            .includes(this.state.filtro.toLowerCase()));
        this.setState({...this.state, onDemandContatos: contatos});
    }

    componentDidMount() {
        const url = URLS.SERVER + URLS.PORT + URLS.APP + URLS.RESOURCE;
        fetch(url, {method: 'GET'})
            .then(response => {
                if (response.ok) {
                    response.json().then(json => {
                        this.setState({...this.state, contatos: json, onDemandContatos: json});
                    })
                } else {
                    console.log('Nenhum contato encontrado!');
                }
            })
            .catch(error => {
                console.log('Servidor fora do ar! cause:' + error);
            })
    }

    render() {
        return (
            <div>
                <Header filtro={this.state.filtro} change={this.change}/>

                <div className="cards">
                    {this.state.onDemandContatos.map(contato => {
                        return <Card key={contato.id} contato={contato}/>
                    })}

                </div>

                <Add/>
            </div>
        );
    }
}

export default Agenda;