import { GoogleLogin } from '@react-oauth/google';

// Aquí puedes mantener tu CLIENT_ID
const CLIENT_ID = '723482709922-4r4nfln40di3g98msfs9a5k00odepri9.apps.googleusercontent.com';

class AuthGoogleService {
  // Método para manejar el login exitoso
  static loginSuccess(response, onSuccess) {
    console.log('Login Successful:', response);
    onSuccess(response); 
  }

  // Método para manejar el login fallido
  static loginFailure(error, onError) {
    console.error('Login Failed:', error);
    onError(error);  
  }

  // Botón de login de Google
  static LoginButton({ onSuccess, onError }) {
    return (
      <GoogleLogin
        onSuccess={(response) => AuthGoogleService.loginSuccess(response, onSuccess)}  
        onError={(error) => AuthGoogleService.loginFailure(error, onError)}  
        useOneTap
        clientId={CLIENT_ID} 
      />
    );
  }
}

export default AuthGoogleService;