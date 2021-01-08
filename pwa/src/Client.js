const axios = require('axios');

axios.create({
    timeout: 5000
});

class Client {
    constructor() {
    }


    static get BASEURL() {
        return "";
    }

    static get(url, params, successHandler, errorHandler) {
        const requestUrl = Client.BASEURL + url;
        axios
            .get(requestUrl, params)
            .then(response => {
                successHandler(response);
            })
            .catch(error => {
                errorHandler(error);
            });
    }

    static post(url, params, successHandler, errorHandler) {
        const requestUrl = Client.BASEURL + url;
        axios
            .post(requestUrl, params)
            .then(response => {
                successHandler(response);
            })
            .catch(error => {
                errorHandler(error);
            });
    }

    static login(params, successHandler, errorHandler) {
        axios
            .post(`${Client.BASEURL}/login/process`, params)
            .then(response => {
                successHandler(response);
            })
            .catch(error => {
                errorHandler(error);
            });
    }
}

export default Client;
