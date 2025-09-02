import { useEffect, useState } from "react";
import { Alert, Button, Card, Col, Row, Spinner } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";
import { useSearchParams } from "react-router-dom";
import MySpinner from "./layout/MySpinner";

const Home = () => {
    const [products, setProducts] = useState([]);
    const [page, setPage] = useState(1);
    const [loading, setLoading] = useState(true);
    const [q] = useSearchParams();

    const loadProducts = async () => {
        try {
            setLoading(true);
            let url = `${endpoints['products']}?page=${page}`;

            let cate = q.get("cateId");
            if (cate) 
                url = `${url}&cateId=${cate}`;

            let res = await Apis.get(url);
            if (res.data.length > 0)
                setProducts([...products, ...res.data]);
            else
                setPage(0)
        } catch (ex) {
            console.error(ex);
        } finally {
            setLoading(false);
        }
    }

    useEffect(() => {
        if (page > 0)
            loadProducts();
    }, [page, q]);

    useEffect(() => {
        setProducts([]);
        setPage(1);
    }, [q]);


    const loadMore = () => {
        setPage(page + 1);
    }

    return (
        <>
            {products.length == 0 && <Alert variant="warning" className="mt-2">KHÔNG có sản phẩm nào!</Alert>}
            <Row>
                {products.map(p => <Col className="p-1" md={3} xs={6} key={p.id}>
                    <Card>
                        <Card.Img variant="top" src={p.image} />
                        <Card.Body>
                            <Card.Title>{p.name}</Card.Title>
                            <Card.Text className="text-danger">{p.price.toLocaleString()} VNĐ</Card.Text>
                            <Button variant="primary me-1">Xem chi tiết</Button>
                            <Button variant="danger">Đặt hàng</Button>
                        </Card.Body>
                    </Card>
                </Col>)}
            </Row>

            {loading && <MySpinner />}

            {page > 0 && <div className="text-center mt-1 mb-1">
                <Button variant="info" onClick={loadMore}>Xem thêm...</Button>
            </div>}
            
        </>
    );
}

export default Home;