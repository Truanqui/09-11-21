import {BrowserRouter as Router, Switch, Route} from "react-router-dom";
import './App.css';
import Home from './pages/home';
import Index from './pages/index';
import Show from './pages/show';
import Insert from './pages/insert';
import Edit from './pages/edit';
import Delete from './pages/delete';
import NotFound from './pages/notfound';

function App() {
  return (
    <Router>
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/index" component={Index} />
        <Route path="/show" component={Show} />
        <Route path="/contatos" component={Insert} />
        <Route path="/edit" component={Edit} />
        <Route path="/delete" component={Delete} />
        <Route path="*" component={NotFound} />        
      </Switch>
    </Router>
  );
}
export default App;