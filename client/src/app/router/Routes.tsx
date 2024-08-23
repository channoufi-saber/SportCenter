import { createBrowserRouter, Navigate } from "react-router-dom";
import Catalog from "../../features/catalog/Catalog";
import ProductDetails from "../../features/catalog/ProductDetails";
import ContactPage from "../../features/contact/ContactPage";
import HomePage from "../../features/home/HomePage";
import NotFound from "../errors/NotFoundError";
import ServerError from "../errors/ServerError";
import App from "../layout/App";

export const router = createBrowserRouter([
	{
		path: '/',
		element: <App />,
		children: [
			{ path: '', element: <HomePage /> },
			{ path: 'store', element: <Catalog /> },
			{ path: 'store/:id', element: <ProductDetails /> },
			{ path: 'contact', element: <ContactPage /> },
			{ path: 'not-found', element: <NotFound /> },
			{ path: 'server-error', element: <ServerError /> },
			{ path: '*', element: <Navigate replace to='/not-found' /> }

		]
	}

])