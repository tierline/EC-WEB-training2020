import React from 'react';
import { IonList, IonItem, IonLabel, IonContent, IonNote } from '@ionic/react';
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
        const id = parseInt(params.id, 10)
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
                        <IonNote>{this.state.data.description}</IonNote>
                    </IonItem>
                </IonList>
            </IonContent >
        );
    }
}

export default Detail;