import React from 'react';
import { IonList, IonItem, IonLabel, IonContent } from '@ionic/react';
import Action from "./Action";

class Home extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            data: []
        }
    }

    componentDidMount() {
        Action.findList(this);
    }

    render() {
        const items = this.state.data.map((item) =>
            <IonItem>
                <IonLabel>{item.name}</IonLabel>
            </IonItem>);
        return (
            <IonContent>
                <IonList>
                    {items}
                </IonList>
            </IonContent >
        );
    }
}

export default Home;