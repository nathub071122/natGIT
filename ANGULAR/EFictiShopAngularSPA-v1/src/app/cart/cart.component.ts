import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent {
  // data binding ensures that whenever the model changes the template is automatically updated.
  items = this.cartService.getItemsInService();
  //create the form and configure from the code (power)
  checkoutForm = this.formBuilder.group({
    nameFormControl : '<Name Here>',
    addressFormControl : ''
  });
  constructor(private cartService: CartService,private formBuilder:FormBuilder) {}
  onCheckout(): void {
    // empty the cart in the service, and assign it to the the items in the component
    // clear the items in the UI due to data bidning with string interpolation
    this.items = this.cartService.clearCartInService();
    console.log("Order is submitted with ", this.checkoutForm.value)
  }
}
