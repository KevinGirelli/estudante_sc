import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SchoolRoutingModule } from './school-routing.module';
import { SchoolDashboardComponent } from './components/school-dashboard/school-dashboard.component';

import { Routes } from '@angular/router';

const routes: Routes = [
  {path: "dashboard", component: SchoolDashboardComponent }
];

@NgModule({
  declarations: [
    SchoolDashboardComponent
  ],
  imports: [
    CommonModule,
    SchoolRoutingModule
  ]
})
export class SchoolModule { }
