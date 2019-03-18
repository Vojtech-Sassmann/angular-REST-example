import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {InstancesOverviewComponent} from "./instances-overview/instances-overview.component";

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'instances',
    component: InstancesOverviewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
