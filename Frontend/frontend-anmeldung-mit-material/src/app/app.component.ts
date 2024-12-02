import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SecondPageComponent } from "./second-page/second-page.component";
import { HomeComponent } from "./home/home.component";

@Component( {
  selector: 'app-root',
  standalone: true,
  imports: [ RouterOutlet, SecondPageComponent, HomeComponent ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
} )
export class AppComponent {
  title = 'frontend-anmeldung-mit-material';
}
