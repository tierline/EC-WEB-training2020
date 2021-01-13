import Client from "./Client";

class Action {
    static findList(component) {
        Client.get(
            `/api/all`,
            response => {
                component.setState(() => ({
                    data: response
                }));
            }, err => { }
        );
    }

    static findDetail(id, component) {
        Client.get(
            `/api/detail/${id}`,
            response => {
                component.setState(() => ({
                    data: response
                }));
            }, err => { }
        );
    }
}

export default Action;