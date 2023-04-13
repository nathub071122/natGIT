import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { CartService } from '../cart.service';

@Component({
  selector: 'app-shipping',
  templateUrl: './shipping.component.html',
  styleUrls: ['./shipping.component.css']
})
export class ShippingComponent implements OnInit {
  shippingCostsObservable!: Observable<{type:string, price:number}[]>;
constructor(private cartService:CartService){

}
ngOnInit(): void {
  this.shippingCostsObservable = this.cartService.getShippingPrices();
}
}
