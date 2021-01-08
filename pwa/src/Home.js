import React from 'react';
import { IonButton, IonList, IonItem, IonLabel, IonContent } from '@ionic/react';
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
                <IonButton color="primary" href={"/detail/" + item.id}>詳細</IonButton>
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