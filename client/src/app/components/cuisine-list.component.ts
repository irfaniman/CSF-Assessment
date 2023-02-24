import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Restaurant } from '../models';

@Component({
  selector: 'app-cuisine-list',
  templateUrl: './cuisine-list.component.html',
  styleUrls: ['./cuisine-list.component.css']
})
export class CuisineListComponent implements OnInit{

	// TODO Task 2
	// For View 1
  cuisineForm!: FormGroup

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void { }
  
  processCuisineForm() {
    const cuisine: Restaurant = this.cuisineForm.value as Restaurant
  }

}
