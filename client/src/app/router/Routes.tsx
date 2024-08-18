import { createBrowserRouter } from "react-router-dom";
import Catalog from "../../features/catalog/Catalog";
import ProductDetails from "../../features/catalog/ProductDetails";
import ContactPage from "../../features/contact/ContactPage";
import HomePage from "../../features/home/HomePage";
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

		]
	}

])