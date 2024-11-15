import { GoogleLogin } from '@react-oauth/google';

const CLIENT_ID = '723482709922-4r4nfln40di3g98msfs9a5k00odepri9.apps.googleusercontent.com';

class AuthGoogleService {
  static loginSuccess(response, onSuccess) {
    console.log('Login Successful:', response);
    onSuccess(response); 
  }

  static loginFailure(error, onError) {
    console.error('Login Failed:', error);
    onError(error);  
  }

  static LoginButton({ onSuccess, onError }) {
    return (
      <GoogleLogin
        clientId={CLIENT_ID}
        onSuccess={(response) => AuthGoogleService.loginSuccess(response, onSuccess)}
        onError={(error) => AuthGoogleService.loginFailure(error, onError)}
        useOneTap
        uxMode="popup"
        redirectUri="https://localhost:3000"
        scope="email profile"
      />
    );
  }
}

export default AuthGoogleService;