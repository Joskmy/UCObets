import React, { useState } from 'react';
import { GoogleOAuthProvider } from '@react-oauth/google'; 
import Login from './Components/Login/Login';
import SideBar from './Components/SideBar/SideBar';
import CreateCity from './Components/CreateCity/CreateCity';


const CLIENT_ID = '723482709922-4r4nfln40di3g98msfs9a5k00odepri9.apps.googleusercontent.com'; 

const App = () => {
  const [isAuthenticated, setIsAuthenticated] = useState(false); 

  const handleLoginSuccess = (response) => {
    console.log('Login Successful:', response);
    setIsAuthenticated(true);
  };

  const handleLoginFailure = (error) => {
    console.error('Login Failed:', error);
    setIsAuthenticated(false); 
  };

  return (
    <GoogleOAuthProvider clientId={CLIENT_ID}>
      <div>
        {!isAuthenticated ? (
          <Login 
            onLoginSuccess={handleLoginSuccess} 
            onLoginFailure={handleLoginFailure} 
          />
        ) : (
          <>
            <SideBar />
            <CreateCity />
          </>
        )}
      </div>
    </GoogleOAuthProvider>
  );
};

export default App;