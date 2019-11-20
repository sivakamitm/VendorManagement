import { Component } from '@angular/core';
import { LogoutService } from './logout.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})


export class AppComponent {
  constructor(private router:Router) { }
  title = 'UST-Evaluation';


}


