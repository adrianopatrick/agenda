import React from 'react';
import Header from './components/Header';
import Card from './components/Card';
import Add from './components/Add';

class App extends React.Component {

    /*constructor(){
     super();

     }*/

    render() {
        return (
            <div>
                <Header/>

                <div className="cards">
                    <Card/>
                </div>

               <Add/>
            </div>
        );
    }
}

export default App;
