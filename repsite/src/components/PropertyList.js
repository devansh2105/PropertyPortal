import React, {useEffect, useState} from "react";
import axios from 'axios'
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import {Row} from "react-bootstrap";
import Container from "react-bootstrap/Container";
import {Link} from "react-router-dom";

const PropertyList = () => {

    const [properties, setProperties] = useState([])

    useEffect(() => {
        const url = "http://localhost:8080/api/v1/properties"

        axios.get(url).then((response) => {
            setProperties(response.data.properties)
        })
    }, [])

    const cards = properties.map(property =>
        <Col key={property.id} className="mt-4" md={4}>
            <Card style={{width: '18rem'}}>
                <Card.Img variant="top" src={"data:image/png;base64," + property.picture}/>
                <Card.Body>
                    <Card.Title>{property.type + " for " + property.saleOrRent}</Card.Title>
                    <Card.Text>{property.price + " Euro"}</Card.Text>
                    <Card.Text>{property.city}</Card.Text>
                    <Card.Text className={"text-truncate"}>{property.description}</Card.Text>
                    <Link to={"/properties/" + property.id}> <Button>View details</Button></Link>
                </Card.Body>
            </Card>
        </Col>
    )

    return (

        <Container><Row>{cards}</Row></Container>
    )

}

export default PropertyList;