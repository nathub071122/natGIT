import { Component } from '@angular/core';
// import {productsFromFile} from '../products'
import {products} from '../productsRepository'

//Annotations / Decorator
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent {
// products = productsFromFile;
products = products;

share() {
  window.alert('Share the product!');
  // alert('Share the product');
}
// event hanlder in the parent component which handles the information from the event emitted by the child component.
onNotifyHandlerInParent() {
  window.alert("You will be alerted on offers for the product!!")
}
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/