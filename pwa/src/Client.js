const axiosBase = require('axios');
const axios = axiosBase.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
        'X-Requested-With': 'XMLHttpRequest'
    },
    responseType: 'json'
});


class Client {
    static get(url, successHandler, errorHandler) {
        axios.get(url)
            .then(function (response) {
                successHandler(response.data);
            })
            .catch(function (error) {
                errorHandler(error);
            });
    }

    static post(url, params, successHandler, errorHandler) {
        axios.get(url, { params: params })
            .then(function (response) {
                successHandler(response.data);
            })
            .catch(function (error) {
                errorHandler(error);
            });
    }
}

export default Client;
