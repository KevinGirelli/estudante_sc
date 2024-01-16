import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SchoolRoutingModule } from './school-routing.module';
import { SchoolDashboardComponent } from './components/school-dashboard/school-dashboard.component';


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
