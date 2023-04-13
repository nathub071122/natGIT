import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './productsRepository';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  // in memory store / volatile
  items : Product[] = [];
  // HttpClient helps access REST Endpoints.
  constructor(private httpClient : HttpClient) { }
  addtoCartInService(product:Product){
    this.items.push(product);
  }
  getItemsInService(){
    return this.items;
  }
  clearCartInService(){
    this.items = [];
    return this.items;
  }
  getShippingPrices(){
    // return this.httpClient.get('http://localhost:8080/shipping');
    return this.httpClient.get<{type:string,price:number}[]>('./assets/shipping.json');
  }
}
