import { Component, OnInit } from '@angular/core';
import {PerunInstance} from "../PerunInstance";
import {InstancesService} from "../instances.service";

@Component({
  selector: 'app-instances-overview',
  templateUrl: './instances-overview.component.html',
  styleUrls: ['./instances-overview.component.css']
})
export class InstancesOverviewComponent implements OnInit {

  constructor(private instancesService : InstancesService) { }

  title = 'Prehled instanci';

  newInstanceOwner = "";
  newInstanceUrl = "";
  newInstanceVersion = "";

  instances : PerunInstance[] = [];

  ngOnInit() {
    this.instancesService.getInstances().subscribe(instances => this.instances = instances);
  }

  addInstance() {
    let newInstance : PerunInstance = {
      id: null,
      owner: this.newInstanceOwner,
      url: this.newInstanceUrl,
      version: this.newInstanceVersion
    };

    this.instancesService.addInstance(newInstance).subscribe(response => {
      console.log(response);
      this.ngOnInit();
    });
  }
}
