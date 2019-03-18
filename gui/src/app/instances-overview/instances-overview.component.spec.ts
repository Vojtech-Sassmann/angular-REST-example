import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InstancesOverviewComponent } from './instances-overview.component';

describe('InstancesOverviewComponent', () => {
  let component: InstancesOverviewComponent;
  let fixture: ComponentFixture<InstancesOverviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InstancesOverviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InstancesOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
