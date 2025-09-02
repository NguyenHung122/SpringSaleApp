import { useEffect, useState } from "react";
import { Container, Nav, Navbar, NavDropdown } from "react-bootstrap";
import Apis, { endpoints } from "../../configs/Apis";
import { Link } from "react-router-dom";

const Header = () => {
    const [categories, setCategories] = useState([]);

    const loadCates = async () => {
        let res = await Apis.get(endpoints['categories']);
        setCategories(res.data);
    }

    useEffect(() => {
        loadCates();
    }, []);

    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="#home">E-commerce Website</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link className="nav-link" to="/">Trang chủ</Link>
                      
                        <NavDropdown title="Danh mục" id="basic-nav-dropdown">
                            {categories.map(c => <Link to={`/?cateId=${c.id}`} key={c.id} className="dropdown-item">{c.name}</Link>)}
                        </NavDropdown>

                        <Link className="nav-link text-success" to="/register">Đăng ký</Link>
                        <Link className="nav-link text-danger" to="/login">Đăng nhập</Link>
                    </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
        </>
    );
}

export default Header;