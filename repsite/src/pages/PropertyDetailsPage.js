import React, {useEffect, useState} from "react";
import axios from 'axios';
import ActionHeader from "../components/ActionHeader";
import PropertyDetail from "../components/PropertyDetail";
import Container from "react-bootstrap/Container";

const PropertyDetailsPage = (props) => {

    const propertyId = props.match.params.propertyId;

    const [property, setProperty] = useState(null)

    useEffect(() => {

        const url = "http://localhost:8080/api/v1/properties/" + propertyId;

        axios.get(url).then((response) => {
            setProperty(response.data)
        })

    }, [propertyId])

    return (
        <div>
            <ActionHeader/>
            {/* eslint-disable-next-line react/jsx-no-undef */}
            <Container className="mt-4">
                {property && (<PropertyDetail property={property}/>
                )}
            </Container>
        </div>
    )
}

export default PropertyDetailsPage;