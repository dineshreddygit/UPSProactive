import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';


@NgModule({
  declarations: [
    AppComponent,
    CustomerProfileComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
