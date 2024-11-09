// Login.js
import React, { useState } from 'react';
import { GoogleLogin } from '@react-oauth/google';
import './Login.css';

const Login = ({ onLoginSuccess, onLoginFailure }) => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (e) => setEmail(e.target.value);
  const handlePasswordChange = (e) => setPassword(e.target.value);

  const handleLogin = () => {
    console.log('Email:', email);
    console.log('Password:', password);
  };

  return (
    <div className="login-container">
      <div className="card">
        <div className="card-body">
          <h1 className="h3 mb-3 fw-normal">Log In</h1>
          <div className="form-floating">
            <input
              type="email"
              className="form-control"
              id="floatingInput"
              placeholder="name@example.com"
              value={email}
              onChange={handleEmailChange}
            />
            <label htmlFor="floatingInput">Email address</label>
          </div>
          <div className="form-floating mt-1">
            <input
              type="password"
              className="form-control"
              id="floatingPassword"
              placeholder="Password"
              value={password}
              onChange={handlePasswordChange}
            />
            <label htmlFor="floatingPassword">Password</label>
          </div>
          <div className="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me" /> Remember me
            </label>
          </div>
          <button className="btn btn-primary w-100" onClick={handleLogin}>
            Sign in
          </button>

          <div className="or-container">
            <div className="line-separator"></div>
            <div className="or-label">or</div>
            <div className="line-separator"></div>
          </div>

          <div className="row">
            <GoogleLogin
              onSuccess={(response) => onLoginSuccess(response)}
              onError={(error) => onLoginFailure(error)}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
