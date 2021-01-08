import React from 'react';
import { IonList, IonItem, IonLabel, IonContent } from '@ionic/react';
import Action from "./Action";

class Detail extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            data: {}
        }
    }

    componentDidMount() {
        const { params } = this.props.match
        console.log(params);
        const id = parseInt(params.id, 10)
        console.log(id);
        Action.findDetail(id, this);
    }

    render() {
        return (
            <IonContent>
                <IonList>
                    <IonItem>
                        <IonLabel>{this.state.data.name}</IonLabel>
                    </IonItem>
                    <IonItem>
                        <IonLabel>{this.state.data.price}</IonLabel>
                    </IonItem>
                    <IonItem>
                        <IonLabel>{this.state.data.description}</IonLabel>
                    </IonItem>
                </IonList>
            </IonContent >
        );
    }
}

export default Detail;