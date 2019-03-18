import { Component, OnInit } from '@angular/core';
import {PerunInstance} from "../PerunInstance";

@Component({
  selector: 'app-instances-overview',
  templateUrl: './instances-overview.component.html',
  styleUrls: ['./instances-overview.component.css']
})
export class InstancesOverviewComponent implements OnInit {

  constructor() { }

  title = 'Prehled instanci';

  instances : PerunInstance[] = [
    {
      id : 1,
      version : "3.4.5",
      owner : "Vojtech Sassmann",
      url : "perun.cesnet.cz"
    },
    {
      id : 2,
      version : "3.2.5",
      owner : "Martin Kuba",
      url : "perun-dev.cesnet.cz"
    }
  ];

  ngOnInit() {
  }
}
