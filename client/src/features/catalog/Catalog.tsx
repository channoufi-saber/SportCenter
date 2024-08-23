import { useEffect, useState } from "react";
import agent from "../../app/api/agent";
import Spinner from "../../app/layout/Spinner";
import { Product } from "../../app/models/product";
import ProductList from "./ProductList";

export default function Catalog() {
	const [products, setProducts] = useState<Product[]>([])
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		agent.Store.list().then((products) => setProducts(products.content))
			.catch(error => console.log(error))
			.finally(() => setLoading(false));
	}, []);
	if (!products) return <h3>Unable to load Products</h3>
	if (loading) return <Spinner message='Loading Products...' />

	return (
		<>
			<ProductList products={products} />
		</>
	)
}