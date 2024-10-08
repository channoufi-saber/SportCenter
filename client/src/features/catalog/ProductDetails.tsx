import { Typography } from "@mui/material";
import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { Product } from "../../app/models/product";

export default function ProductDetails() {
	const { id } = useParams<{ id: string }>();
	const [product, setProduct] = useState<Product | null>();
	const [loading, setLoading] = useState(true);

	useEffect(() => {
		axios.get(`http://localhost:8081/api/products/${id}`)
			.then(response => setProduct(response.data))
			.catch(error => console.error(error))
			.finally(() => setLoading(false));
	}, [id])
	if (loading) return <h3>Loading Product...</h3>
	if (!product) return <h3>Product not found</h3>
	return (
		<Typography variant="h2" >{product.name}</Typography>

	)
}