import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideFirebaseApp, initializeApp } from '@angular/fire/app';
import { provideAuth, getAuth } from '@angular/fire/auth';
import { provideFirestore, getFirestore } from '@angular/fire/firestore';

import { routes } from './app.routes';
import { environment } from '../environments/environment';


export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(routes),
    provideFirebaseApp(() => initializeApp(environment.firebaseConfig)), // ✅ Make sure 'firebaseConfig' exists
    provideAuth(() => getAuth()),
    provideFirestore(() => getFirestore()),
   
    // Removed `importProvidersFrom()` since it's empty. If needed, add required providers inside.
  ]
};
