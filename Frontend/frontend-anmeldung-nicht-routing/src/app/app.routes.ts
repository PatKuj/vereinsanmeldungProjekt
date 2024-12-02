import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SecondPageComponent } from './second-page/second-page.component';

export const routes: Routes = [
    { 'path': '', component: HomeComponent },
    { 'path': 'second-page', component: SecondPageComponent }
];
