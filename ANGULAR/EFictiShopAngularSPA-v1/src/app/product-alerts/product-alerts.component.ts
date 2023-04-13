import { Component,EventEmitter,Input, Output } from "@angular/core";
import { Product } from "../productsRepository";

@Component({
  selector: 'app-product-alerts',
  templateUrl :'./product-alerts.component.html',
  styleUrls: ['./product-alerts.component.css']
})
export class ProductAlertsComponent {
  // property product should be passed as input from the parent component.
@Input() product! : Product;
@Output() notifyEventEmitterInChild = new EventEmitter();
}