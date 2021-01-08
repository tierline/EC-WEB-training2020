import Client from "./Client";

class Action {
    static findList(component) {
        Client.post(
            `/`,
            {},
            response => {
                component.setState(() => ({
                    data: response.data
                }));
            }, err => { }
        );
    }

    static findDetail(id, component) {
        Client.post(
            `/product/detail/${id}`,
            {},
            response => {
                component.setState(() => ({
                    data: response.data
                }));
            }, err => { }
        );
    }
}

export default Action;