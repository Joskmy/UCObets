import React from 'react';
import { GoogleLogin } from '@react-oauth/google';

const Login = ({ onSuccess, onError }) => {
  return (
    <div className="login-container">
      <h1 className="login-title">Log In</h1>
      
      <form className="login-form">
        <div className="form-group">
          <label>Email address</label>
          <input type="email" placeholder="name@example.com" />
        </div>
        
        <div className="form-group">
          <label>Password</label>
          <input type="password" placeholder="Password" />
        </div>
        
        <div className="remember-me">
          <input type="checkbox" id="remember" />
          <label htmlFor="remember">Remember me</label>
        </div>
        
        <button type="submit" className="sign-in-button">
          Sign In
        </button>
      </form>
      
      <div className="divider">
        <span>or</span>
      </div>
      
      <div className="google-login">
        <GoogleLogin
          onSuccess={onSuccess}
          onError={onError}
          useOneTap
        />
      </div>
    </div>
  );
};

export default Login;