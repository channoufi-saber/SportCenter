import axios, { AxiosError, AxiosResponse } from "axios";
import { toast } from "react-toastify";
import { router } from "../router/Routes";


axios.defaults.baseURL = 'http://localhost:8081/api/';

const idle = () => new Promise(resolve => setTimeout(resolve, 100));
const responseBody = (response: AxiosResponse) => response.data;
axios.interceptors.response.use(async response => {
	await idle()
	return response
}, (error: AxiosError) => {
	const { status } = error.response as AxiosResponse;
	switch (status) {
		case 404:
			toast.error("Resource not found");
			router.navigate('/not-found');
			break;

		case 500:
			toast.error("Internal server error occurred");
			router.navigate('/server-error');
			break;
		default: break;
	}
	return Promise.reject(error.message)
})
const requests = {
	get: (url: string) => axios.get(url).then(responseBody),
	post: (url: string, body: object) => axios.post(url, body).then(responseBody),
	put: (url: string, body: object) => axios.put(url, body).then(responseBody),
	delete: (url: string) => axios.put(url).then(responseBody),

}

const Store = {
	list: () => requests.get('products'),
	get: (id: number) => requests.get(`products/${id}`)
}

const agent = {
	Store
}

export default agent;