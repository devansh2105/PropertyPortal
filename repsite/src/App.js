import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import PropertyDetailsPage from "./pages/PropertyDetailsPage";
import PropertyCreatorPage from "./pages/PropertyCreatorPage";
import SearchPropertiesPage from "./pages/SearchPropertiesPage";

const NoMatchRoute = () => <div>404 Page not found</div>;

const App = () => {
    return (
        <Router>
            <Switch>
                <Route path="/properties" exact component={SearchPropertiesPage}/>
                <Route path="/properties/new" component={PropertyCreatorPage}/>
                <Route path="/properties/:propertyId" component={PropertyDetailsPage}/>
                <Route component={NoMatchRoute}/>
            </Switch>
        </Router>
    );
};
export default App;