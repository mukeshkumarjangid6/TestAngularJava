import { Component } from '@angular/core';
import personsData from './persons.json';  

interface Person {  
  id: Number;  
  first_name: String;
  last_name: String;
  email: String;  
  gender: String;  
}
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Unit-Test-Case';

  persons: Person[] = personsData;
}
