import Client from "./Client";

class Action {
    static findList(component) {
        Client.get(
            `/index`,
            response => {
                component.setState(() => ({
                    data: response
                }));
            }, err => { }
        );
    }

    static findDetail(id, component) {
        Client.get(
            `/product/detail/${id}`,
            response => {
                component.setState(() => ({
                    data: response
                }));
            }, err => { }
        );
    }
}

export default Action;